/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import PropTypes from 'prop-types';

export const ExperienceType = {
	hasLockedSegmentsExperiment: PropTypes.bool,
	name: PropTypes.string.isRequired,
	priority: PropTypes.number.isRequired,
	segmentsEntryId: PropTypes.string.isRequired,
	segmentsEntryName: PropTypes.string,
	segmentsExperienceId: PropTypes.string.isRequired,
	segmentsExperimentStatus: PropTypes.shape(ExperimentStatusType),
	segmentsExperimentURL: PropTypes.string,
};

export const SegmentType = {
	name: PropTypes.string.isRequired,
	segmentsEntryId: PropTypes.string.isRequired,
};

export const ExperimentStatusType = {
	label: PropTypes.string.isRequired,
	value: PropTypes.number.isRequired,
};
