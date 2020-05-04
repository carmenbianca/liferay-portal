/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

AUI.add(
	'liferay-product-navigation-control-menu',
	A => {
		var ControlMenu = {
			init(containerId) {
				var instance = this;

				var controlMenu = A.one(containerId);

				if (controlMenu) {
					var namespace = controlMenu.attr('data-namespace');

					instance._namespace = namespace;

					Liferay.Util.toggleControls(controlMenu);

					var eventHandle = controlMenu.on(
						['focus', 'mousemove', 'touchstart'],
						() => {
							Liferay.fire('initLayout');

							eventHandle.detach();
						}
					);
				}
			},
		};

		Liferay.ControlMenu = ControlMenu;
	},
	'',
	{
		requires: [
			'aui-node',
			'aui-overlay-mask-deprecated',
			'event-move',
			'event-touch',
			'liferay-menu-toggle',
		],
	}
);
