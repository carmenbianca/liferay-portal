/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import '@testing-library/jest-dom/extend-expect';
import {cleanup, render} from '@testing-library/react';
import React from 'react';

import UnsafeHTML from '../../../../src/main/resources/META-INF/resources/page_editor/app/components/UnsafeHTML';

describe('UnsafeHTML', () => {
	afterEach(cleanup);

	it('renders the given HTML markup', () => {
		const {getByRole} = render(
			<UnsafeHTML markup="<h1>Hello <strong>Gürjen</strong></h1>" />
		);

		expect(getByRole('heading')).toBeInTheDocument();
	});

	it('allows adding any className', () => {
		const {container} = render(
			<UnsafeHTML className="food" markup="Pi<strong>zz</strong>a" />
		);

		expect(container.querySelector('.food')).toBeInTheDocument();
	});

	it('allows using a custom HTML tag as container', () => {
		const {getByRole} = render(
			<UnsafeHTML markup="The Title" TagName="h1" />
		);

		expect(getByRole('heading')).toBeInTheDocument();
	});
});
