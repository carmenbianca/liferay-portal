/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayIcon from '@clayui/icon';
import ClaySticker from '@clayui/sticker';
import classNames from 'classnames';
import PropTypes from 'prop-types';
import React from 'react';

const UserIcon = ({fullName = '', portraitURL = '', size = 'lg', userId}) => {
	const stickerColor = parseInt(userId, 10) % 10;

	return (
		<ClaySticker
			className={classNames('sticker-use-icon', {
				[`user-icon-color-${stickerColor}`]: !portraitURL,
			})}
			displayType="secondary"
			shape="circle"
			size={size}
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
};

UserIcon.propTypes = {
	fullName: PropTypes.string,
	portraitURL: PropTypes.string,
	userId: PropTypes.string.isRequired,
};

export default UserIcon;
