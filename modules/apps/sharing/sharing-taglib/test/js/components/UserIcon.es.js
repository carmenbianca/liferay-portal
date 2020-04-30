/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {cleanup, render} from '@testing-library/react';
import React from 'react';

import UserIcon from '../../../src/main/resources/META-INF/resources/collaborators/js/components/UserIcon.es';

describe('UserIcon', () => {
	afterEach(cleanup);

	it('renders', () => {
		const {asFragment} = render(
			<UserIcon fullName="Jane Smith" userId="1000" />
		);

		expect(asFragment()).toMatchSnapshot();
	});
});
