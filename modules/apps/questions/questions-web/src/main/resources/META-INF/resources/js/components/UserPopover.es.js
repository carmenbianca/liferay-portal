/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayPopover from '@clayui/popover';
import React from 'react';

import {dateToBriefInternationalHuman} from '../utils/utils.es';
import UserIcon from './UserIcon.es';

export default ({creator, statistics}) => {
	return (
		<ClayPopover
			alignPosition="bottom"
			className="questions-user-popover"
			disableScroll={true}
			header={
				<div className="align-items-center d-flex">
					<UserIcon
						fullName={creator.name}
						portraitURL={creator.image}
						userId={String(creator.id)}
					/>

					<div className="c-ml-2">
						<h4 className="font-weight-light h6 text-secondary">
							{statistics.rank}
						</h4>

						<h3 className="h5">{creator.name}</h3>
					</div>
				</div>
			}
		>
			<div className="text-secondary">
				<p className="c-mb-0">Posts: {statistics.postsNumber}</p>
				<p className="c-mb-0">
					Join Date:{' '}
					{dateToBriefInternationalHuman(statistics.joinDate)}
				</p>
				<p className="c-mb-0">
					Last Post Date:{' '}
					{dateToBriefInternationalHuman(statistics.lastPostDate)}
				</p>
			</div>
		</ClayPopover>
	);
};
