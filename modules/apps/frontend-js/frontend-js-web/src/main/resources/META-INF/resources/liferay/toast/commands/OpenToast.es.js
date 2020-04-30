/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayAlert from '@clayui/alert';
import {render} from 'frontend-js-react-web';
import React from 'react';
import {unmountComponentAtNode} from 'react-dom';

const DEFAULT_ALERT_CONTAINER_ID = 'alertContainer';

const DEFAULT_RENDER_DATA = {
	portletId: 'UNKNOWN_PORTLET_ID',
};

const TOAST_AUTO_CLOSE_INTERVAL = 5000;

const getDefaultAlertContainer = () => {
	let container = document.getElementById(DEFAULT_ALERT_CONTAINER_ID);

	if (!container) {
		container = document.createElement('div');
		container.id = DEFAULT_ALERT_CONTAINER_ID;
		document.body.appendChild(container);
	}

	return container;
};

/**
 * Function that implements the Toast pattern, which allows to present feedback
 * to user actions as a toast message in the lower left corner of the page
 *
 * @param {string} message The message to show in the toast notification
 * @param {string} title The title associated with the message
 * @param {string} displayType The displayType of notification to show. It can be one of the
 * following: 'danger', 'info', 'success', 'warning'
 * @return {ClayToast} The Alert toast created
 * @review
 */

function openToast({
	containerId,
	message = '',
	renderData = DEFAULT_RENDER_DATA,
	title = Liferay.Language.get('success'),
	toastProps = {},
	type = 'success',
	variant,
}) {
	const container =
		document.getElementById(containerId) || getDefaultAlertContainer();

	unmountComponentAtNode(container);

	const onClose = () => unmountComponentAtNode(container);

	render(
		<ClayAlert.ToastContainer>
			<ClayAlert
				autoClose={TOAST_AUTO_CLOSE_INTERVAL}
				displayType={type}
				onClose={onClose}
				title={title}
				variant={variant}
				{...toastProps}
			>
				{message}
			</ClayAlert>
		</ClayAlert.ToastContainer>,
		renderData,
		container
	);
}

export {openToast};
export default openToast;
