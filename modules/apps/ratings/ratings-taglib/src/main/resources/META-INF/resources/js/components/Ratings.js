/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {fetch, objectToFormData} from 'frontend-js-web';
import PropTypes from 'prop-types';
import React, {useCallback} from 'react';

import {errorToast} from '../utils/toast';
import RatingsLike from './RatingsLike';
import RatingsStars from './RatingsStars';
import RatingsThumbs from './RatingsThumbs';

const TYPES = {
	LIKE: 'like',
	STARS: 'stars',
	THUMBS: 'thumbs',
};

const Ratings = ({
	className,
	classPK,
	enabled = false,
	inTrash = false,
	signedIn,
	type,
	url,
	...restProps
}) => {
	const getDefaultTitle = () => {
		if (!signedIn) {
			return '';
		}

		if (inTrash) {
			return Liferay.Language.get(
				'ratings-are-disabled-because-this-entry-is-in-the-recycle-bin'
			);
		}
		else if (!enabled) {
			return Liferay.Language.get('ratings-are-disabled-in-staging');
		}
	};

	const sendVoteRequest = useCallback(
		score => {
			Liferay.fire('ratings:vote', {
				className,
				classPK,
				ratingType: type,
				score,
			});

			const body = objectToFormData({
				className,
				classPK,
				p_auth: Liferay.authToken,
				p_l_id: themeDisplay.getPlid(),
				score,
			});

			return fetch(url, {
				body,
				method: 'POST',
			})
				.then(response => response.json())
				.catch(() => {
					errorToast();
				});
		},
		[className, classPK, type, url]
	);

	const RatingsTypes = {
		[TYPES.LIKE]: RatingsLike,
		[TYPES.STARS]: RatingsStars,
		[TYPES.THUMBS]: RatingsThumbs,
	};

	const RatingsComponent = RatingsTypes[type];

	return (
		<RatingsComponent
			{...restProps}
			disabled={!signedIn || !enabled}
			inititalTitle={getDefaultTitle()}
			sendVoteRequest={sendVoteRequest}
		/>
	);
};

Ratings.propTypes = {
	className: PropTypes.string.isRequired,
	classPK: PropTypes.string.isRequired,
	enabled: PropTypes.bool,
	inTrash: PropTypes.bool,
	signedIn: PropTypes.bool.isRequired,
	type: PropTypes.string.isRequired,
	url: PropTypes.string.isRequired,
};

export default Ratings;
