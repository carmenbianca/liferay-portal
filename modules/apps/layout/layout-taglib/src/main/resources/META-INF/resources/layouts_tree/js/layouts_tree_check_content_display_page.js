/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

AUI.add(
	'liferay-layouts-tree-check-content-display-page',
	A => {
		var CSS_LAYOUT_INVALID = 'layout-page-invalid';

		var CSS_TREE_HITAREA = A.getClassName('tree', 'hitarea');

		var STR_HOST = 'host';

		var LayoutsTreeCheckContentDisplayPage = A.Component.create({
			EXTENDS: A.Plugin.Base,

			NAME: 'layoutstreecheckcontentdisplaypage',

			NS: 'checkContentDisplayPage',

			prototype: {
				_beforeClickNodeEl(event) {
					var result;

					if (!event.target.test('.' + CSS_TREE_HITAREA)) {
						var link = event.currentTarget.one('a');

						if (!link || link.hasClass(CSS_LAYOUT_INVALID)) {
							result = new A.Do.Halt();
						}
					}

					return result;
				},

				_beforeFormatNodeLabel(node, cssClass, label) {
					var result;

					if (!node.contentDisplayPage) {
						cssClass = cssClass + ' ' + CSS_LAYOUT_INVALID;

						result = new A.Do.AlterArgs(
							'Added layout-page-invalid CSS class',
							[
								node,
								cssClass,
								label,
								Liferay.Language.get(
									'this-page-is-not-a-content-display-page-template'
								),
							]
						);
					}

					return result;
				},

				_formatRootNode() {
					var instance = this;

					return new A.Do.AlterReturn(
						'Modified label attribute',
						A.merge(A.Do.currentRetVal, {
							label: instance.get(STR_HOST).get('root').label,
						})
					);
				},

				_onTreeAppend(event) {
					var instance = this;

					var host = instance.get(STR_HOST);

					host.fire('checkContentDisplayTreeAppend', {
						node: event.tree.node,
					});
				},

				destructor() {
					var instance = this;

					new A.EventHandle(instance._eventHandles).detach();
				},

				initializer() {
					var instance = this;

					var host = instance.get(STR_HOST);

					instance._eventHandles = [
						instance.afterHostEvent(
							'append',
							instance._onTreeAppend,
							instance
						),
						instance.doAfter(
							'_formatRootNode',
							instance._formatRootNode,
							instance
						),
						instance.doBefore(
							'_formatNodeLabel',
							instance._beforeFormatNodeLabel,
							instance
						),
						instance.doBefore(
							'_onClickNodeEl',
							instance._beforeClickNodeEl,
							instance
						),
					];

					host.get('boundingBox').addClass('lfr-tree-display-page');
				},
			},
		});

		A.Plugin.LayoutsTreeCheckContentDisplayPage = LayoutsTreeCheckContentDisplayPage;
	},
	'',
	{
		requires: ['aui-component', 'plugin'],
	}
);
