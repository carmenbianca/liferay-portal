/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import updateLayoutData from '../../../../src/main/resources/META-INF/resources/page_editor/app/actions/updateLayoutData';
import updatePageContents from '../../../../src/main/resources/META-INF/resources/page_editor/app/actions/updatePageContents';
import LayoutService from '../../../../src/main/resources/META-INF/resources/page_editor/app/services/LayoutService';
import updateItemConfig from '../../../../src/main/resources/META-INF/resources/page_editor/app/thunks/updateItemConfig';

jest.mock(
	'../../../../src/main/resources/META-INF/resources/page_editor/app/actions/updateLayoutData',
	() => jest.fn()
);

jest.mock(
	'../../../../src/main/resources/META-INF/resources/page_editor/app/actions/updatePageContents',
	() => jest.fn()
);

jest.mock(
	'../../../../src/main/resources/META-INF/resources/page_editor/app/services/InfoItemService',
	() => ({
		getPageContents: jest.fn(() =>
			Promise.resolve([
				{
					classPK: 'pk',
					name: 'contents',
					title: 'title',
					usagesCount: 1,
				},
			])
		),
	})
);

jest.mock(
	'../../../../src/main/resources/META-INF/resources/page_editor/app/services/LayoutService',
	() => ({updateItemConfig: jest.fn()})
);

describe('updateItemConfig', () => {
	afterEach(() => {
		LayoutService.updateItemConfig.mockClear();
		updateLayoutData.mockClear();
	});

	const runThunk = () =>
		updateItemConfig({
			config: {},
			itemConfig: {},
			itemId: '0',
			segmentsExperienceId: '0',
		})(() => {});

	it('calls LayoutService.updateItemConfig with the given information', () => {
		LayoutService.updateItemConfig.mockImplementation(() =>
			Promise.resolve()
		);

		runThunk();
		expect(LayoutService.updateItemConfig).toHaveBeenCalled();
	});

	it('dispatches updateLayoutData and updatePageContents actions', async () => {
		LayoutService.updateItemConfig.mockImplementation(() =>
			Promise.resolve({
				items: {},
				version: 1,
			})
		);

		await runThunk();

		expect(updateLayoutData).toHaveBeenCalledWith({
			layoutData: {
				items: {},
				version: 1,
			},
		});

		expect(updatePageContents).toHaveBeenCalledWith({
			pageContents: [
				{
					classPK: 'pk',
					name: 'contents',
					title: 'title',
					usagesCount: 1,
				},
			],
		});
	});
});
