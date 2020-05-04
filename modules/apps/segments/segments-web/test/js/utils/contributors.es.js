/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {applyConjunctionChangeToContributor} from '../../../src/main/resources/META-INF/resources/js/utils/contributors.es';

describe('applyConjunctionChangeToContributor', () => {
	it('changes contributors to selected conjunction', () => {
		const mockContributors = [
			{
				conjunctionId: 'and',
			},
			{
				conjunctionId: 'and',
			},
		];
		const newConjunctionName = 'or';

		const updatedContributors = applyConjunctionChangeToContributor(
			mockContributors,
			newConjunctionName
		);

		updatedContributors.map(c =>
			expect(c).toEqual(
				expect.objectContaining({conjunctionId: newConjunctionName})
			)
		);
	});

	it('does not change contributors to selected conjunction when it is not supported', () => {
		const mockContributors = [
			{
				conjunctionId: 'and',
			},
			{
				conjunctionId: 'and',
			},
		];
		const newConjunctionName = 'bad_conjunction';

		const updatedContributors = applyConjunctionChangeToContributor(
			mockContributors,
			newConjunctionName
		);

		updatedContributors.map(c =>
			expect(c).toEqual(expect.objectContaining({conjunctionId: 'and'}))
		);
	});

	it('does not change contributors to selected conjunction when it is already in the contributor', () => {
		const mockContributors = [
			{
				conjunctionId: 'and',
			},
			{
				conjunctionId: 'and',
			},
		];
		const newConjunctionName = 'and';

		const updatedContributors = applyConjunctionChangeToContributor(
			mockContributors,
			newConjunctionName
		);

		updatedContributors.map(c =>
			expect(c).toEqual(expect.objectContaining({conjunctionId: 'and'}))
		);
	});
});
