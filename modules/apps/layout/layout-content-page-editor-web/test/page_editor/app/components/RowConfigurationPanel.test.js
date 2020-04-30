/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import '@testing-library/jest-dom/extend-expect';
import {cleanup, fireEvent, render} from '@testing-library/react';
import React from 'react';

import {RowConfigurationPanel} from '../../../../src/main/resources/META-INF/resources/page_editor/app/components/floating-toolbar/RowConfigurationPanel';
import {StoreAPIContextProvider} from '../../../../src/main/resources/META-INF/resources/page_editor/app/store';
import updateItemConfig from '../../../../src/main/resources/META-INF/resources/page_editor/app/thunks/updateItemConfig';
import updateRowColumns from '../../../../src/main/resources/META-INF/resources/page_editor/app/thunks/updateRowColumns';

const renderComponent = (dispatch = () => {}) =>
	render(
		<StoreAPIContextProvider
			dispatch={dispatch}
			getState={() => ({segmentsExperienceId: '0'})}
		>
			<RowConfigurationPanel
				item={{
					children: [],
					config: {gutters: true},
					itemId: '0',
					parentId: '',
					type: '',
				}}
			/>
		</StoreAPIContextProvider>
	);

jest.mock(
	'../../../../src/main/resources/META-INF/resources/page_editor/app/config',
	() => ({config: {}})
);

jest.mock(
	'../../../../src/main/resources/META-INF/resources/page_editor/app/thunks/updateItemConfig',
	() => jest.fn()
);

jest.mock(
	'../../../../src/main/resources/META-INF/resources/page_editor/app/thunks/updateRowColumns',
	() => jest.fn()
);

describe('RowConfigurationPanel', () => {
	afterEach(() => {
		cleanup();
		updateItemConfig.mockClear();
		updateRowColumns.mockClear();
	});

	it('allows changing the number of columns of a row', async () => {
		const {getByLabelText} = renderComponent();
		const input = getByLabelText('number-of-columns');

		await fireEvent.change(input, {
			target: {value: '6'},
		});

		expect(updateRowColumns).toHaveBeenCalledWith({
			itemId: '0',
			numberOfColumns: 6,
			segmentsExperienceId: '0',
		});
	});

	it('allows changing the gutter', async () => {
		const {getByLabelText} = renderComponent();
		const input = getByLabelText('columns-gutter');

		await fireEvent.click(input);

		expect(updateItemConfig).toHaveBeenCalledWith({
			itemConfig: {gutters: false},
			itemId: '0',
			segmentsExperienceId: '0',
		});
	});
});
