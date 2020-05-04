/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {
	convertUTCDateToLocalDate,
	getTimezoneOffsetHour,
} from '../../src/utils/date';

describe('convertUTCDateToLocalDate()', () => {
	it('returns the converted local date', () => {
		const date = new Date('2020-01-01T00:00:00.000Z');

		expect(convertUTCDateToLocalDate(date)).toEqual(
			new Date('2020-01-01T00:00:00.000Z')
		);
	});
});

describe('getTimezoneOffsetHour()', () => {
	it('returns the timezone offset hour', () => {
		const date = new Date('2020-01-01T00:00:00.000Z');

		expect(getTimezoneOffsetHour(date)).toBe('+00:00');
	});
});
