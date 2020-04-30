/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayIcon from '@clayui/icon';
import ClaySticker from '@clayui/sticker';
import PropTypes from 'prop-types';
import React from 'react';

export default function UserIcon({fullName = '', portraitURL = '', userId}) {
	const stickerColor = parseInt(userId, 10) % 10;

	return (
		<ClaySticker
			className={`flex-shrink-0 sticker-use-icon user-icon-color-${stickerColor}`}
			displayType="secondary"
			shape="circle"
			size="lg"
		>
			{portraitURL ? (
				<div className="sticker-overlay">
					<img
						alt={`${fullName}.`}
						className="sticker-img"
						src={portraitURL}
					/>
				</div>
			) : (
				<ClayIcon symbol="user" />
			)}
		</ClaySticker>
	);
}

UserIcon.propTypes = {
	fullName: PropTypes.string,
	portraitURL: PropTypes.string,
	userId: PropTypes.string.isRequired,
};
