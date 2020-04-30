/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import ClayIcon from '@clayui/icon';
import React, {useEffect, useState} from 'react';

import {createVoteMessage, createVoteThread} from '../utils/client.es';
import {normalize, normalizeRating} from '../utils/utils.es';

export default ({aggregateRating, entityId, myRating, ratingChange, type}) => {
	const [userRating, setUserRating] = useState(0);
	const [rating, setRating] = useState(0);

	useEffect(() => {
		setRating(normalizeRating(aggregateRating));
	}, [aggregateRating]);

	useEffect(() => {
		setUserRating(myRating === null ? 0 : normalize(myRating));
	}, [myRating]);

	const voteChange = value => {
		if (userRating === value) {
			return;
		}

		const newUserRating = userRating + value;
		const normalizedValue = (newUserRating + 1) / 2;
		const votePromise =
			type === 'Thread'
				? createVoteThread(entityId, normalizedValue)
				: createVoteMessage(entityId, normalizedValue);

		votePromise.then(({ratingValue}) => {
			const denormalizedValue = normalize(ratingValue);

			const newRating = rating - userRating + denormalizedValue;

			setRating(newRating);
			setUserRating(newUserRating);

			if (ratingChange) {
				ratingChange(newRating);
			}
		});
	};

	return (
		<div className="align-items-center d-inline-flex flex-md-column justify-content-center text-secondary">
			<ClayButton
				className={
					'text-reset' + (userRating === 1 ? ' text-primary' : '')
				}
				displayType="unstyled"
				monospaced
				onClick={() => voteChange(1)}
			>
				<ClayIcon symbol="caret-top" />
			</ClayButton>

			<span className="c-px-2">{rating || 0}</span>

			<ClayButton
				className={
					'text-reset' + (userRating === -1 ? ' text-primary' : '')
				}
				displayType="unstyled"
				// small={if-it-is-a-sub-comment}
				monospaced
				onClick={() => voteChange(-1)}
			>
				<ClayIcon symbol="caret-bottom" />
			</ClayButton>
		</div>
	);
};
