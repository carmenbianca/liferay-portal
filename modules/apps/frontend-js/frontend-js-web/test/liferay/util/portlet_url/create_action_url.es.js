/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

'use strict';

import createActionURL from '../../../../src/main/resources/META-INF/resources/liferay/util/portlet_url/create_action_url.es';

describe('Liferay.Util.PortletURL.createActionURL', () => {
	it('returns a URL object with a href parameter containing the p_p_lifecycle parameter set to 1', () => {
		Liferay = {
			ThemeDisplay: {
				getPortalURL: jest.fn(() => 'http://localhost:8080'),
			},
		};

		const portletURL = createActionURL(
			'http://localhost:8080/group/control_panel/manage?p_p_id=foo'
		);

		expect(portletURL.href).toEqual(
			'http://localhost:8080/group/control_panel/manage?p_p_id=foo&p_p_lifecycle=1'
		);
	});
});
