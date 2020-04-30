/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {cleanup, fireEvent, render} from '@testing-library/react';
import React from 'react';

import DecimalInput from '../../../../src/main/resources/META-INF/resources/js/components/inputs/DecimalInput.es';
import {testControlledInput} from '../../utils';

const DECIMAL_NUMBER_INPUT_TESTID = 'decimal-number';

describe('DecimalInput', () => {
	afterEach(cleanup);

	it('renders type decimal number', () => {
		const mockOnChange = jest.fn();

		const defaultNumberValue = '1.23';
		const newNumberValue = '2.34';

		const {asFragment, getByTestId} = render(
			<DecimalInput onChange={mockOnChange} value={defaultNumberValue} />
		);

		expect(asFragment()).toMatchSnapshot();

		const element = getByTestId(DECIMAL_NUMBER_INPUT_TESTID);

		testControlledInput({
			element,
			mockFunc: mockOnChange,
			newValue: newNumberValue,
			value: defaultNumberValue,
		});
	});

	it('formats the value after blur', () => {
		const mockOnChange = jest.fn();

		const {getByTestId} = render(<DecimalInput onChange={mockOnChange} />);

		const element = getByTestId(DECIMAL_NUMBER_INPUT_TESTID);

		fireEvent.change(element, {
			target: {value: '1.009'},
		});

		fireEvent.blur(element);

		expect(mockOnChange.mock.calls[1][0]).toMatchObject({value: '1.01'});
	});
});
