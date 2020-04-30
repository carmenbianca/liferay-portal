/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {isModifyingKey} from '../../../src/main/resources/META-INF/resources/js/util/dom.es';

describe('DOM Utilities', () => {
	describe('isModifyingKey', () => {
		it('identity modifying keys', () => {
			expect(isModifyingKey(65)).toEqual(true);
			expect(isModifyingKey(18)).toEqual(false);
		});
	});
});
