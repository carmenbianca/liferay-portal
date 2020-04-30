/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {config} from '../config/index';
import serviceFetch from './serviceFetch';

export default {
	/**
	 * Adds a Widget to the current layout
	 * @param {object} options
	 * @param {function} options.onNetworkStatus
	 * @param {string} options.portletId Portlet id of the Widget
	 * @param {string} options.parentItemId id of the parent where the portlet is going to be added
	 * @param {string} options.position position where the portlet is going to be added
	 * @param {string} options.portletId Portlet id of the Widget
	 * @param {string} options.segmentsExperienceId Current segmentsExperienceId
	 * @return {Promise<object>}
	 */
	addPortlet({
		onNetworkStatus,
		parentItemId,
		portletId,
		position,
		segmentsExperienceId,
	}) {
		return serviceFetch(
			config.addPortletURL,
			{
				body: {
					parentItemId,
					portletId,
					position,
					segmentsExperienceId,
				},
			},
			onNetworkStatus,
			{requestGenerateDraft: true}
		);
	},
};
