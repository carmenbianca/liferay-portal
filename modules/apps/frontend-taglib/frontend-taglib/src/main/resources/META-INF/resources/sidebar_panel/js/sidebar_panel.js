/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

AUI.add(
	'liferay-sidebar-panel',
	A => {
		var Lang = A.Lang;

		var SidebarPanel = A.Component.create({
			ATTRS: {
				resourceUrl: {
					validator: Lang.isString,
				},

				searchContainerId: {
					validator: Lang.isString,
				},

				targetNode: {
					setter: A.one,
				},
			},

			AUGMENTS: [Liferay.PortletBase],

			EXTENDS: A.Base,

			NAME: 'liferaysidebarpanel',

			prototype: {
				_bindUI() {
					var instance = this;

					instance._eventHandles = [
						instance._searchContainer.on(
							'rowToggled',
							A.debounce(
								instance._getSidebarContent,
								50,
								instance
							),
							instance
						),
						Liferay.after('refreshInfoPanel', () => {
							setTimeout(() => {
								instance._getSidebarContent();
							}, 0);
						}),
					];
				},

				_detachSearchContainerRegisterHandle() {
					var instance = this;

					var searchContainerRegisterHandle =
						instance._searchContainerRegisterHandle;

					if (searchContainerRegisterHandle) {
						searchContainerRegisterHandle.detach();

						instance._searchContainerRegisterHandle = null;
					}
				},

				_getSidebarContent() {
					var instance = this;

					Liferay.Util.fetch(instance.get('resourceUrl'), {
						body: new FormData(
							instance._searchContainer.getForm().getDOM()
						),
						method: 'POST',
					})
						.then(response => response.text())
						.then(response =>
							instance.get('targetNode').setContent(response)
						);
				},

				_onSearchContainerRegistered(event) {
					var instance = this;

					var searchContainer = event.searchContainer;

					if (
						searchContainer.get('id') ===
						instance.get('searchContainerId')
					) {
						instance._searchContainer = searchContainer;

						instance._detachSearchContainerRegisterHandle();

						instance.get('targetNode').plug(A.Plugin.ParseContent);

						instance._bindUI();
					}
				},

				destructor() {
					var instance = this;

					instance._detachSearchContainerRegisterHandle();

					new A.EventHandle(instance._eventHandles).detach();
				},

				initializer() {
					var instance = this;

					instance._searchContainerRegisterHandle = Liferay.on(
						'search-container:registered',
						instance._onSearchContainerRegistered,
						instance
					);
				},
			},
		});

		Liferay.SidebarPanel = SidebarPanel;
	},
	'',
	{
		requires: [
			'aui-base',
			'aui-debounce',
			'aui-parse-content',
			'liferay-portlet-base',
		],
	}
);
