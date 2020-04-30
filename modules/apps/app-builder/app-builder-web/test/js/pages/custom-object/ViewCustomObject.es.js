/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {act, cleanup, fireEvent, render} from '@testing-library/react';
import React from 'react';
import {HashRouter} from 'react-router-dom';

import {AppContextProvider} from '../../../../src/main/resources/META-INF/resources/js/AppContext.es';
import ViewCustomObject from '../../../../src/main/resources/META-INF/resources/js/pages/custom-object/ViewCustomObject.es';

import '@testing-library/jest-dom/extend-expect';

describe('ViewCustomObject', () => {
	const RESPONSE = {
		name: {
			en_US: 'Custom Object',
		},
	};

	const ViewCustomObjectWithRouter = () => (
		<>
			<div className="tools-control-group">
				<div className="control-menu-level-1-heading" />
			</div>
			<HashRouter>
				<AppContextProvider value={{}}>
					<ViewCustomObject
						match={{
							params: {
								dataDefinitionId: 1,
							},
						}}
					></ViewCustomObject>
				</AppContextProvider>
			</HashRouter>
		</>
	);

	beforeEach(() => {
		jest.useFakeTimers();
	});

	afterEach(() => {
		cleanup();
		jest.clearAllTimers();
		jest.restoreAllMocks();
	});

	afterAll(() => {
		jest.useRealTimers();
	});

	it('renders', async () => {
		fetch.mockResponseOnce(JSON.stringify(RESPONSE));

		const {asFragment} = render(<ViewCustomObjectWithRouter />);

		await act(async () => {
			jest.runAllTimers();
		});

		expect(asFragment()).toMatchSnapshot();
	});

	it('clicks on tabs and checks if they are active', async () => {
		fetch.mockResponse(JSON.stringify(RESPONSE));

		const {queryByText} = render(<ViewCustomObjectWithRouter />);

		await act(async () => {
			jest.runAllTimers();
		});

		expect(queryByText(RESPONSE.name.en_US)).toBeTruthy();

		const tableViewsTab = queryByText('table-views');
		fireEvent.click(tableViewsTab);
		expect(tableViewsTab.classList.contains('active')).toBeTruthy();
	});
});
