/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import RuleList from '../../../../src/main/resources/META-INF/resources/js/components/RuleList/RuleList.es';

let component;

const spritemap = 'icons.svg';

const pages = [
	{
		rows: [
			{
				columns: [
					{
						fields: [
							{
								fieldName: 'text1',
								label: 'label text 1',
							},
							{
								fieldName: 'text2',
								label: 'label text 2',
							},
						],
					},
				],
			},
		],
	},
];

const configDefault = {
	pages,
	rules: [
		{
			actions: [
				{
					action: 'require',
					label: 'label text 1',
					target: 'text1',
				},
			],
			conditions: [
				{
					operands: [
						{
							type: 'field',
							value: 'text1',
						},
						{
							type: 'value',
							value: 'value 2',
						},
					],
					operator: 'contains',
				},
				{
					operands: [
						{
							type: 'field',
							value: 'text1',
						},
						{
							type: 'field',
							value: 'text2',
						},
					],
					operator: 'equals-to',
				},
			],
			['logical-operator']: 'OR',
		},
		{
			actions: [
				{
					action: 'show',
					label: 'label text 2',
					target: 'text2',
				},
			],
			conditions: [
				{
					operands: [
						{
							type: 'field',
							value: 'text1',
						},
						{
							type: 'value',
							value: 'value 3',
						},
					],
					operator: 'not-equals-to',
				},
			],
			['logical-operator']: 'AND',
		},
	],
	spritemap,
};

describe('RuleList', () => {
	beforeEach(() => {
		jest.useFakeTimers();
	});

	afterEach(() => {
		if (component) {
			component.dispose();
		}
	});

	it('returns the field label for each action', () => {
		component = new RuleList(configDefault);

		const contextLabel =
			component.pages[0].rows[0].columns[0].fields[0].label;

		const actionLabel = component.rules[0].actions[0].label;

		jest.runAllTimers();

		expect(actionLabel).toEqual(contextLabel);
	});

	it('shows message when rule list is empty', () => {
		component = new RuleList({
			pages,
			rules: [],
			spritemap,
			strings: {
				emptyListText:
					'there-are-no-rules-yet-click-on-plus-icon-below-to-add-the-first',
			},
		});

		expect(component).toMatchSnapshot();
	});

	it('shows rule list', () => {
		component = new RuleList(configDefault);

		expect(component).toMatchSnapshot();
	});
});
