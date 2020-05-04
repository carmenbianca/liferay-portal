/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {cleanup, render} from '@testing-library/react';
import React from 'react';
import {wrapInTestContext} from 'react-dnd-test-utils';

import {default as Component} from '../../../../src/main/resources/META-INF/resources/js/components/criteria_builder/CriteriaGroup.es';

const connectDnd = jest.fn(el => el);

const CriteriaGroup = wrapInTestContext(Component);

describe('CriteriaGroup', () => {
	afterEach(cleanup);

	it('renders', () => {
		const {asFragment} = render(
			<CriteriaGroup connectDragPreview={connectDnd} propertyKey="user" />
		);

		expect(asFragment()).toMatchSnapshot();
	});
});
