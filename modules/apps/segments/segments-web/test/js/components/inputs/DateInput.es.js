/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {cleanup, render} from '@testing-library/react';
import dateFns from 'date-fns';
import React from 'react';

import DateInput from '../../../../src/main/resources/META-INF/resources/js/components/inputs/DateInput.es';
import {testControlledDateInput} from '../../utils';

const DATE_INPUT_TESTID = 'date-input';

describe('DateInput', () => {
	afterEach(cleanup);

	it('renders type date', () => {
		const mockOnChange = jest.fn();

		const defaultNumberValue = '2019-01-23';

		const {asFragment, getByTestId} = render(
			<DateInput onChange={mockOnChange} value={defaultNumberValue} />
		);

		expect(asFragment()).toMatchSnapshot();

		const element = getByTestId(DATE_INPUT_TESTID);

		testControlledDateInput({
			element,
			mockOnChangeFunc: mockOnChange,
			newValue: '2019-01-24',
			newValueExpected: '2019-01-24',
			newValueOnChange: '2019-01-24',
			value: defaultNumberValue,
		});
	});

	it('renders now with wrong date', () => {
		const mockOnChange = jest.fn();

		const defaultNumberValue = '2019-01-23';

		const {asFragment, getByTestId} = render(
			<DateInput onChange={mockOnChange} value={defaultNumberValue} />
		);

		expect(asFragment()).toMatchSnapshot();

		const element = getByTestId(DATE_INPUT_TESTID);

		const date = dateFns.format(new Date(), 'YYYY-MM-DD');

		testControlledDateInput({
			element,
			mockOnChangeFunc: mockOnChange,
			newValue: '2019-01-XX',
			newValueExpected: date,
			newValueOnChange: date,
			value: defaultNumberValue,
		});
	});
});
