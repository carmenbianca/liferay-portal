/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {normalizeEvent, sortByEventDate} from '../../src/utils/events';

describe('Event Utils', () => {
	it('sorts events by eventDate, from oldest most recent events', () => {
		const events = [
			'2019-12-01',
			'2017-03-01',
			'2020-04-20',
			'2020-04-07',
			'2017-07-15',
		].map(dateStr => {
			const date = new Date(dateStr);

			return {
				eventDate: date.toISOString(),
			};
		});

		const expectedResultOrder = [
			events[1],
			events[4],
			events[0],
			events[3],
			events[2],
		];

		expect(events.sort(sortByEventDate)).toEqual(
			expect.arrayContaining(expectedResultOrder)
		);
	});

	it('returns a normalized event', () => {
		const eventId = 'pageViewed';
		const applicationId = 'Page';
		const contextHash = 12345;
		const properties = {};

		expect(
			normalizeEvent(eventId, applicationId, properties, contextHash)
		).toEqual(
			expect.objectContaining({
				applicationId,
				contextHash,
				eventDate: expect.any(String),
				eventId,
				eventLocalDate: expect.any(String),
				properties,
			})
		);
	});
});
