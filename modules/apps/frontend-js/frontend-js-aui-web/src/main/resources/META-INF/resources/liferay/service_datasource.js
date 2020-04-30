/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

AUI.add(
	'liferay-service-datasource',
	A => {
		var ServiceDataSource = A.Component.create({
			EXTENDS: A.DataSource.Local,
			NAME: 'servicedatasource',
			prototype: {
				_defRequestFn(event) {
					var instance = this;

					var source = instance.get('source');

					source(
						event.request,
						A.rbind('_serviceCallbackFn', instance, event)
					);
				},

				_serviceCallbackFn(obj, xHR, event) {
					var instance = this;

					instance.fire(
						'data',
						A.mix(
							{
								data: obj,
							},
							event
						)
					);
				},
			},
		});

		Liferay.Service.DataSource = ServiceDataSource;
	},
	'',
	{
		requires: ['aui-base', 'datasource-local'],
	}
);
