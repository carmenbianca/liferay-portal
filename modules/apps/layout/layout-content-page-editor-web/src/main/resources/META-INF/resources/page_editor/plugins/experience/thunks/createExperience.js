/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ExperienceService from '../../../app/services/ExperienceService';
import createExperienceAction from '../actions/createExperience';
import selectExperienceAction from '../actions/selectExperience';

export default function createExperience({name, segmentsEntryId}) {
	return dispatch => {
		return ExperienceService.createExperience({
			body: {
				name,
				segmentsEntryId,
			},
			dispatch,
		}).then(({fragmentEntryLinks, layoutData, segmentsExperience}) => {
			ExperienceService.selectExperience({
				body: {
					segmentsExperienceId:
						segmentsExperience.segmentsExperienceId,
				},
				dispatch,
			})
				.then(portletIds => {
					return dispatch(
						selectExperienceAction({
							portletIds,
							segmentsExperienceId:
								segmentsExperience.segmentsExperienceId,
						})
					);
				})
				.catch(error => {
					return error;
				});

			return dispatch(
				createExperienceAction({
					fragmentEntryLinks,
					layoutData,
					segmentsExperience,
				})
			);
		});
	};
}
