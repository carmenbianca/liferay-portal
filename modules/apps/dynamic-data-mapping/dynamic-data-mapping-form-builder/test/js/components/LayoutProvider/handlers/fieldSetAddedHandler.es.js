/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import handleFieldSetAdded from '../../../../../src/main/resources/META-INF/resources/js/components/LayoutProvider/handlers/fieldSetAddedHandler.es';
import mockPages from '../../../__mock__/mockPages.es';

describe('LayoutProvider/handlers/fieldSetAddedHandler', () => {
	describe('handleFieldSetAdded(props, state, event)', () => {
		it('inserts the fieldset page to the current page', () => {
			const event = {
				fieldSetPage: [
					{
						rows: [
							{
								columns: [
									{
										fields: [
											{
												fieldName: 'field1',
												settingsContext: {
													pages: [],
												},
											},
										],
									},
								],
							},
						],
					},
				],
				target: {
					pageIndex: 0,
					rowIndex: 1,
				},
			};
			const state = {
				pages: mockPages,
			};

			const newState = handleFieldSetAdded({}, state, event);

			expect(
				newState.pages[0].rows[1].columns[0].fields[0].fieldName
			).toEqual('field1');
		});
	});
});
