/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import updateLayoutData from '../../../../src/main/resources/META-INF/resources/page_editor/app/actions/updateLayoutData';
import LayoutService from '../../../../src/main/resources/META-INF/resources/page_editor/app/services/LayoutService';
import updateRowColumns from '../../../../src/main/resources/META-INF/resources/page_editor/app/thunks/updateRowColumns';

jest.mock(
	'../../../../src/main/resources/META-INF/resources/page_editor/app/config',
	() => ({config: {}})
);

jest.mock(
	'../../../../src/main/resources/META-INF/resources/page_editor/app/actions/updateLayoutData',
	() => jest.fn()
);

jest.mock(
	'../../../../src/main/resources/META-INF/resources/page_editor/app/services/LayoutService',
	() => ({updateRowColumns: jest.fn()})
);

describe('updateRowColumns', () => {
	beforeEach(() => {
		LayoutService.updateRowColumns.mockClear();
		updateLayoutData.mockClear();

		LayoutService.updateRowColumns.mockImplementation(() =>
			Promise.resolve()
		);

		LayoutService.updateRowColumns.mockImplementation(() =>
			Promise.resolve({
				layoutData: {
					items: {},
					version: 1,
				},
			})
		);
	});

	const runThunk = () =>
		updateRowColumns({
			itemId: '0',
			numberOfColumns: 6,
			segmentsExperienceId: '0',
		})(() => {});

	it('calls LayoutService.updateRowColumns with the given information', () => {
		runThunk();

		expect(LayoutService.updateRowColumns).toHaveBeenCalledWith(
			expect.objectContaining({
				itemId: '0',
				numberOfColumns: 6,
				segmentsExperienceId: '0',
			})
		);
	});

	it('dispatch updateLayoutData action when the promise is resolved', async () => {
		await runThunk();

		expect(updateLayoutData).toHaveBeenCalledWith({
			layoutData: {
				items: {},
				version: 1,
			},
		});
	});
});
