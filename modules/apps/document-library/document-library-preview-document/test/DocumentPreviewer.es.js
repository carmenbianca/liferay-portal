/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {cleanup, render} from '@testing-library/react';
import React from 'react';

import DocumentPreviewer from '../src/main/resources/META-INF/resources/preview/js/DocumentPreviewer.es';

describe('document-library-preview-document', () => {
	afterEach(cleanup);

	it('renders a document previewer with ten pages and the first page rendered', () => {
		const {asFragment} = render(
			<DocumentPreviewer
				baseImageURL="/document-images/"
				initialPage={1}
				spritemap="icons.svg"
				totalPages={10}
			/>
		);

		expect(asFragment()).toMatchSnapshot();
	});

	it('renders a document previewer with nineteen pages and the fifth page rendered', () => {
		const {asFragment} = render(
			<DocumentPreviewer
				baseImageURL="/document-images/"
				initialPage={5}
				spritemap="icons.svg"
				totalPages={19}
			/>
		);

		expect(asFragment()).toMatchSnapshot();
	});
});
