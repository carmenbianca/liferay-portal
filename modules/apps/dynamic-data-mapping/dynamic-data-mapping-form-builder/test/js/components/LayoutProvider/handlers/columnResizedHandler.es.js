/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import * as columnResizedHandler from '../../../../../src/main/resources/META-INF/resources/js/components/LayoutProvider/handlers/columnResizedHandler.es';

const props = {};
const source = {};

describe('LayoutProvider/handlers/columnResizedHandler', () => {
	describe('handleResizeRight(props, state, source, index, columnTarget)', () => {
		it('resizes first field to the left', () => {
			const indexes = [
				{
					columnIndex: 0,
					pageIndex: 0,
					rowIndex: 0,
				},
			];
			const state = {
				pages: [
					{
						rows: [
							{
								columns: [
									{
										fields: [{}],
										size: 4,
									},
									{
										fields: [{}],
										size: 8,
									},
								],
							},
						],
					},
				],
			};

			const result = columnResizedHandler.handleResizeRight(
				props,
				state,
				source,
				indexes,
				2
			);

			expect(result[0].rows[0].columns[0].size).toEqual(2);
			expect(result[0].rows[0].columns[1].size).toEqual(10);
		});

		it('resizes first field to the right', () => {
			const indexes = [
				{
					columnIndex: 0,
					pageIndex: 0,
					rowIndex: 0,
				},
			];
			const state = {
				pages: [
					{
						rows: [
							{
								columns: [
									{
										fields: [{}],
										size: 4,
									},
									{
										fields: [{}],
										size: 8,
									},
								],
							},
						],
					},
				],
			};

			const result = columnResizedHandler.handleResizeRight(
				props,
				state,
				source,
				indexes,
				6
			);

			expect(result[0].rows[0].columns[0].size).toEqual(6);
			expect(result[0].rows[0].columns[1].size).toEqual(6);
		});

		it('resizes second field to the left', () => {
			const indexes = [
				{
					columnIndex: 1,
					pageIndex: 0,
					rowIndex: 0,
				},
			];
			const state = {
				pages: [
					{
						rows: [
							{
								columns: [
									{
										fields: [{}],
										size: 4,
									},
									{
										fields: [{}],
										size: 8,
									},
								],
							},
						],
					},
				],
			};

			const result = columnResizedHandler.handleResizeRight(
				props,
				state,
				source,
				indexes,
				6
			);

			expect(result[0].rows[0].columns[0].size).toEqual(4);
			expect(result[0].rows[0].columns[1].size).toEqual(2);
			expect(result[0].rows[0].columns.length).toEqual(3);
		});

		it('resizes second field to the right', () => {
			const indexes = [
				{
					columnIndex: 1,
					pageIndex: 0,
					rowIndex: 0,
				},
			];
			const state = {
				pages: [
					{
						rows: [
							{
								columns: [
									{
										fields: [{}],
										size: 4,
									},
									{
										fields: [{}],
										size: 4,
									},
									{
										fields: [{}],
										size: 4,
									},
								],
							},
						],
					},
				],
			};

			const result = columnResizedHandler.handleResizeRight(
				props,
				state,
				source,
				indexes,
				11
			);

			expect(result[0].rows[0].columns[0].size).toEqual(4);
			expect(result[0].rows[0].columns[1].size).toEqual(7);
			expect(result[0].rows[0].columns[2].size).toEqual(1);
		});
	});
});
