/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import AnalyticsClient from '../src/analytics';

describe('Analytics Plugin Integration', () => {
	let Analytics;

	beforeEach(() => {
		Analytics = AnalyticsClient.create();
	});

	afterEach(() => {
		Analytics.reset();
		Analytics.dispose();
	});

	describe('registerPlugin()', () => {
		it('is exposed as an Analytics static method', () => {
			expect(typeof Analytics.registerPlugin).toBe('function');
		});

		it('processes the given plugin and execute its initialization logic', () => {
			const plugin = jest.fn();

			Analytics.registerPlugin(plugin);

			expect(plugin).toHaveBeenCalledWith(Analytics);
			expect(plugin.mock.calls.length).toBe(1);
		});
	});
});
