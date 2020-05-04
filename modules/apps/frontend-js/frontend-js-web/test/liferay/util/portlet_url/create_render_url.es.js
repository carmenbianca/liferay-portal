/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

'use strict';

import createRenderURL from '../../../../src/main/resources/META-INF/resources/liferay/util/portlet_url/create_render_url.es';

describe('Liferay.Util.PortletURL.createRenderURL', () => {
	it('returns a URL object with a href parameter containing the p_p_lifecycle parameter set to 0', () => {
		Liferay = {
			ThemeDisplay: {
				getPortalURL: jest.fn(() => 'http://localhost:8080'),
			},
		};

		const portletURL = createRenderURL(
			'http://localhost:8080/group/control_panel/manage?p_p_id=foo'
		);

		expect(portletURL.href).toEqual(
			'http://localhost:8080/group/control_panel/manage?p_p_id=foo&p_p_lifecycle=0'
		);
	});
});
