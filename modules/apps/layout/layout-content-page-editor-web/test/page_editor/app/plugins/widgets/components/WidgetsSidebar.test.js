/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {cleanup, fireEvent, render} from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import React from 'react';
import {DndProvider} from 'react-dnd';
import HTML5Backend from 'react-dnd-html5-backend';

import {StoreAPIContextProvider} from '../../../../../../src/main/resources/META-INF/resources/page_editor/app/store/index';
import WidgetsSidebar from '../../../../../../src/main/resources/META-INF/resources/page_editor/plugins/widgets/components/WidgetsSidebar';

import '@testing-library/jest-dom/extend-expect';

const widgets = [
	{
		portlets: [
			{
				instanceable: true,
				portletId: 'assetPublisher',
				title: 'Asset Publisher',
				used: false,
			},
			{
				instanceable: true,
				portletId: 'DocumentsAndMedia',
				title: 'Documents and Media',
				used: false,
			},
			{
				instanceable: true,
				portletId: 'NavigationMenu',
				title: 'Navigation Menu',
				used: false,
			},
		],
		title: 'Highlighted',
	},
	{
		portlets: [
			{
				instanceable: false,
				portletId: 'Blogs',
				title: 'Blogs',
				used: false,
			},
			{
				instanceable: false,
				portletId: 'BlogsAggregator',
				title: 'Blogs Aggregator',
				used: false,
			},
		],
		title: 'Collaboration',
	},
];

const RenderWidgetsSidebar = () => {
	return (
		<DndProvider backend={HTML5Backend}>
			<StoreAPIContextProvider getState={() => ({widgets})}>
				<WidgetsSidebar />
			</StoreAPIContextProvider>
		</DndProvider>
	);
};

describe('WidgetsSidebar', () => {
	afterEach(cleanup);

	it('renders the categories collapsed', () => {
		const {getByLabelText, getByText, queryByText} = render(
			<RenderWidgetsSidebar />
		);

		expect(getByText('Collaboration')).toBeInTheDocument();
		expect(getByText('Highlighted')).toBeInTheDocument();
		expect(getByLabelText('search-form')).toBeInTheDocument();

		expect(queryByText('Asset Publisher')).toBe(null);
	});

	it('expands a category on click and closes it when clicking it again', () => {
		const {getByText, queryByText} = render(<RenderWidgetsSidebar />);
		const highlightedCategory = getByText('Highlighted');

		fireEvent.click(highlightedCategory);

		expect(highlightedCategory.getAttribute('aria-expanded')).toBe('true');

		expect(getByText('Asset Publisher')).toBeInTheDocument();

		fireEvent.click(highlightedCategory);

		expect(highlightedCategory.getAttribute('aria-expanded')).toBe('false');

		expect(queryByText('Asset Publisher')).toBe(null);
	});

	it('finds a widget when you search it', () => {
		const {getByLabelText, getByText, queryByText} = render(
			<RenderWidgetsSidebar />
		);

		userEvent.type(getByLabelText('search-form'), 'asset');

		expect(getByText('Asset Publisher')).toBeInTheDocument();

		expect(queryByText('Blogs')).toBe(null);
	});

	it('expands all categories when you type something in search form', () => {
		const {getByLabelText, getByText} = render(<RenderWidgetsSidebar />);

		userEvent.type(getByLabelText('search-form'), 'a');

		expect(getByText('Collaboration').getAttribute('aria-expanded')).toBe(
			'true'
		);
		expect(getByText('Highlighted').getAttribute('aria-expanded')).toBe(
			'true'
		);
	});
});
