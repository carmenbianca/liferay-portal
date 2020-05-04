/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {PagesVisitor} from '../../../src/main/resources/META-INF/resources/js/util/visitors.es';
import mockPages from '../__mock__/mockPages.es';

let visitor;

describe('PagesVisitor', () => {
	beforeEach(() => {
		visitor = new PagesVisitor(mockPages);
	});

	afterEach(() => {
		if (visitor) {
			visitor.dispose();
		}
	});

	it('does not multate the fields of the original array', () => {
		const newPages = visitor.mapFields(field => {
			if (field.fieldName == 'radio') {
				field.fieldName = 'liferay';
			}

			return field;
		});

		expect(mockPages).not.toBe(newPages);
	});

	it('is able to change pages', () => {
		expect(
			visitor.mapPages((page, index) => ({
				...page,
				title: `New title ${index}`,
			}))
		).toMatchSnapshot();
	});

	it('is able to change rows', () => {
		expect(
			visitor.mapRows(row => ({
				...row,
				columns: [],
			}))
		).toMatchSnapshot();
	});

	it('is able to change columns', () => {
		expect(
			visitor.mapColumns(column => ({
				...column,
				size: 6,
			}))
		).toMatchSnapshot();
	});

	it('is able to change fields', () => {
		expect(
			visitor.mapFields((field, index) => ({
				...field,
				label: `New label ${index}`,
			}))
		).toMatchSnapshot();
	});

	it('is able to visit fields and stop when required', () => {
		const visitedFieldNames = [];

		const visitor = new PagesVisitor([
			{
				rows: [
					{
						columns: [
							{
								fields: [
									{
										fieldName: 'fieldA',
									},
									{
										fieldName: 'fieldB',
										nestedFields: [{fieldName: 'fieldC'}],
									},
								],
							},
							{
								fields: [
									{
										fieldName: 'fieldD',
									},
								],
							},
						],
					},
					{
						columns: [
							{
								fields: [
									{
										fieldName: 'fieldE',
									},
								],
							},
						],
					},
				],
			},
			{
				rows: [
					{
						columns: [
							{
								fields: [
									{
										fieldName: 'fieldF',
									},
								],
							},
						],
					},
				],
			},
		]);

		visitor.visitFields(({fieldName}) => {
			visitedFieldNames.push(fieldName);

			if (fieldName.indexOf('C') > -1) {
				return true; // stop
			}

			return false; // continue;
		});

		expect(visitedFieldNames).toEqual(['fieldA', 'fieldB', 'fieldC']);
	});
});
