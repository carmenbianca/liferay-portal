/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayMultiStepNav from '@clayui/multi-step-nav';
import React from 'react';

export default ({currentStep}) => {
	const steps = ['1', '2', '3'];
	const isComplete = index =>
		index !== steps.length - 1 && currentStep > index;

	return (
		<ClayMultiStepNav>
			{steps.map((label, index) => (
				<ClayMultiStepNav.Item
					active={currentStep === index}
					complete={isComplete(index)}
					expand={index < steps.length - 1}
					key={index}
				>
					<ClayMultiStepNav.Divider />

					<ClayMultiStepNav.Indicator
						complete={isComplete(index)}
						label={label}
					/>
				</ClayMultiStepNav.Item>
			))}
		</ClayMultiStepNav>
	);
};
