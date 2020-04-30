/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import createPortletURL from './create_portlet_url.es';

/**
 * Returns a resource portlet URL in form of a URL object by setting the lifecycle parameter
 * @param {!string} basePortletURL The base portlet URL to be modified in this utility
 * @param {object} parameters Search parameters to be added or changed in the base URL
 * @return {URL} Resource Portlet URL
 * @review
 */
export default function createResourceURL(basePortletURL, parameters = {}) {
	return createPortletURL(basePortletURL, {
		...parameters,
		p_p_lifecycle: '2',
	});
}
