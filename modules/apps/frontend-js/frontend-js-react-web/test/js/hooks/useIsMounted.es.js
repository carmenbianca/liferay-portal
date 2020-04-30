/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {cleanup, render} from '@testing-library/react';
import React from 'react';

import useIsMounted from '../../../src/main/resources/META-INF/resources/js/hooks/useIsMounted.es';

const {useEffect} = React;

describe('useIsMounted()', () => {
	afterEach(cleanup);

	/*
	 * Regression test for LPS-105721.
	 */
	it("can be used in a child component's useEffect callback", () => {
		let mounted = false;

		const Parent = ({children}) => {
			const isMounted = useIsMounted();

			const child = React.Children.only(children);

			return React.cloneElement(child, {isMounted});
		};

		const Child = ({isMounted}) => {
			useEffect(() => {
				mounted = isMounted();
			}, [isMounted]);

			return <></>;
		};

		render(
			<Parent>
				<Child />
			</Parent>
		);

		expect(mounted).toBe(true);
	});
});
