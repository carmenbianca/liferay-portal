/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {cleanup, fireEvent, render} from '@testing-library/react';
import React from 'react';

import DestinationUrlInput from '../src/main/resources/META-INF/resources/js/DestinationUrlInput';

const defaultProps = {
	namespace: '_portlet_namespace_',
};

const renderComponent = (props = defaultProps) =>
	render(<DestinationUrlInput {...props} />);

describe('DestinationUrlInput', () => {
	afterEach(cleanup);

	it('renders an input element', () => {
		const {getByLabelText} = renderComponent();

		expect(getByLabelText('destination-url'));
	});

	it('try button is disabled if url is empty', () => {
		const {getByTitle} = renderComponent();

		const tryButton = getByTitle('try-redirection');

		expect(tryButton).toHaveProperty('disabled', true);
	});

	it('try button is enabled if url is not empty', () => {
		const {getByLabelText, getByTitle} = renderComponent();

		const inputElement = getByLabelText('destination-url');

		fireEvent.change(inputElement, {target: {value: 'test'}});

		const tryButton = getByTitle('try-redirection');

		expect(tryButton.disabled).toBe(false);
	});

	it('window open is called with correct url', () => {
		global.open = jest.fn();

		const testingUrl = 'http://test.com';

		const {getByTitle} = renderComponent({
			initialDestinationUrl: testingUrl,
			...defaultProps,
		});

		const tryButton = getByTitle('try-redirection');

		fireEvent.click(tryButton);

		expect(global.open).toBeCalledWith(testingUrl, '_blank');
	});
});
