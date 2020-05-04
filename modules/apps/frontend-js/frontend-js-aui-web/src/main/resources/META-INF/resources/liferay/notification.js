/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

AUI.add(
	'liferay-notification',
	A => {
		var Notification = A.Component.create({
			EXTENDS: Liferay.Alert,

			NAME: 'liferaynotification',

			prototype: {
				_getAlertsContainer(targetNode) {
					var instance = this;

					targetNode = targetNode || A.one('body');

					var alertsContainer = instance._alertsContainer;

					if (!alertsContainer) {
						var rootNode =
							targetNode || instance.get('rootNode') || A;

						alertsContainer =
							(targetNode &&
								targetNode.one(
									'.lfr-notification-container'
								)) ||
							rootNode.one('.lfr-notification-container');

						if (!alertsContainer) {
							alertsContainer = A.Node.create(
								instance.TPL_ALERTS_CONTAINER
							);

							targetNode.prepend(alertsContainer);
						}

						instance._alertsContainer = alertsContainer;
					}

					return alertsContainer;
				},

				TPL_ALERT_NODE: '<div class="lfr-notification-wrapper"></div>',

				TPL_ALERTS_CONTAINER:
					'<div class="lfr-notification-container"></div>',
			},
		});

		Liferay.Notification = Notification;
	},
	'',
	{
		requires: ['liferay-alert'],
	}
);
