/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {cleanup, render} from '@testing-library/react';
import React from 'react';

import EmptyState from '../../../../src/main/resources/META-INF/resources/js/components/table/EmptyState.es';

describe('EmptyState', () => {
	afterEach(cleanup);

	it('renders', () => {
		const {queryByText} = render(
			<EmptyState
				emptyState={{description: 'description', title: 'title'}}
			/>
		);

		expect(queryByText('title')).toBeTruthy();
		expect(queryByText('description')).toBeTruthy();
	});

	it('renders without title', () => {
		const {queryByText} = render(
			<EmptyState emptyState={{description: 'description'}} />
		);

		expect(queryByText('title')).toBeFalsy();
		expect(queryByText('description')).toBeTruthy();
	});
});
