/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {cleanup, render} from '@testing-library/react';
import React from 'react';

import CriteriaSidebar from '../../../../src/main/resources/META-INF/resources/js/components/criteria_sidebar/CriteriaSidebar.es';

describe('CriteriaSidebar', () => {
	afterEach(cleanup);

	it('renders', () => {
		const {asFragment} = render(<CriteriaSidebar propertyGroups={[]} />);

		expect(asFragment()).toMatchSnapshot();
	});
});
