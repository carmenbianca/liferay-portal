/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

AUI.add(
	'liferay-widget-zindex',
	A => {
		var STR_HOST = 'host';

		var WidgetZIndex = A.Component.create({
			EXTENDS: A.Plugin.Base,

			NAME: 'widgetzindex',

			NS: 'zindex',

			prototype: {
				_setHostZIndex() {
					var instance = this;

					instance
						.get(STR_HOST)
						.set('zIndex', ++Liferay.zIndex.WINDOW);
				},

				initializer() {
					var instance = this;

					var host = instance.get(STR_HOST);

					if (!host.get('rendered') && host.get('visible')) {
						instance._setHostZIndex();
					}

					instance.onHostEvent('visibleChange', event => {
						if (event.newVal) {
							instance._setHostZIndex();
						}
					});
				},
			},
		});

		Liferay.WidgetZIndex = WidgetZIndex;
	},
	'',
	{
		requires: ['aui-modal', 'plugin'],
	}
);
