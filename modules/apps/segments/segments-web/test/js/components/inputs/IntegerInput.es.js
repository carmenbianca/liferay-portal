/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {cleanup, render} from '@testing-library/react';
import React from 'react';

import IntegerInput from '../../../../src/main/resources/META-INF/resources/js/components/inputs/IntegerInput.es';
import {testControlledInput} from '../../utils';

const INTEGER_NUMBER_INPUT_TESTID = 'integer-number';

describe('IntegerInput', () => {
	afterEach(cleanup);

	it('renders type integer number', () => {
		const mockOnChange = jest.fn();

		const defaultNumberValue = '1';

		const {asFragment, getByTestId} = render(
			<IntegerInput onChange={mockOnChange} value={defaultNumberValue} />
		);

		expect(asFragment()).toMatchSnapshot();

		const element = getByTestId(INTEGER_NUMBER_INPUT_TESTID);

		testControlledInput({
			element,
			mockFunc: mockOnChange,
			newValue: '2',
			value: defaultNumberValue,
		});
	});
});
