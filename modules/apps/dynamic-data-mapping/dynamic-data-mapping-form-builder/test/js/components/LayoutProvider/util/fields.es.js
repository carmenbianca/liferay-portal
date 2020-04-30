/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import mockPages from '../../../__mock__/mockPages.es';
import {generateFieldName} from '../../../src/main/resources/META-INF/resources/js/components/LayoutProvider/util/fields.es';

describe('LayoutProvider/util/fields', () => {
	describe('generateFieldName(pages, desiredName, currentName)', () => {
		it('generates a name based on the desired name', () => {
			expect(generateFieldName(mockPages, 'New  Name!')).toEqual(
				'NewName'
			);
		});

		it('generates an incremental name when desired name is already being used', () => {
			expect(generateFieldName(mockPages, 'radio')).toEqual('radio1');
		});

		it('generates an incremental name when changing desired name to an already used one', () => {
			expect(generateFieldName(mockPages, 'radio!!')).toEqual('radio1');
		});

		it('fallbacks to currentName when generated name is invalid', () => {
			expect(generateFieldName(mockPages, 'radio!', 'radio')).toEqual(
				'radio'
			);
		});
	});
});
