/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {FormSupport} from 'dynamic-data-mapping-form-renderer';

import * as fieldDeletedHandler from '../../../../../src/main/resources/META-INF/resources/js/components/LayoutProvider/handlers/fieldDeletedHandler.es';
import RulesSupport from '../../../../../src/main/resources/META-INF/resources/js/components/RuleBuilder/RulesSupport.es';
import mockPages from '../../../__mock__/mockPages.es';

describe('LayoutProvider/handlers/fieldDeletedHandler', () => {
	describe('handleFieldDeleted(state, event)', () => {
		it('calls removeRow() when row is left with no fields after delete operation', () => {
			const event = {
				columnIndex: 0,
				pageIndex: 0,
				rowIndex: 0,
			};
			const state = {
				pages: mockPages,
				rules: [],
			};

			const removeRowSpy = jest.spyOn(FormSupport, 'removeRow');

			removeRowSpy.mockImplementation(() => []);

			fieldDeletedHandler.handleFieldDeleted(state, event);

			expect(removeRowSpy).toHaveBeenCalled();

			removeRowSpy.mockRestore();
		});

		it('calls clearAllConditionFieldValues() when deleting a field used as the first operand of a condition', () => {
			const event = {
				columnIndex: 0,
				pageIndex: 0,
				rowIndex: 0,
			};
			const state = {
				pages: mockPages,
				rules: [
					{
						actions: [],
						conditions: [
							{
								operands: [
									{
										value: 'radio',
									},
								],
							},
						],
					},
				],
			};

			const clearAllConditionFieldValuesSpy = jest.spyOn(
				RulesSupport,
				'clearAllConditionFieldValues'
			);

			clearAllConditionFieldValuesSpy.mockImplementation(() => []);

			fieldDeletedHandler.handleFieldDeleted(state, event);

			expect(clearAllConditionFieldValuesSpy).toHaveBeenCalled();

			clearAllConditionFieldValuesSpy.mockRestore();
		});
	});
});
