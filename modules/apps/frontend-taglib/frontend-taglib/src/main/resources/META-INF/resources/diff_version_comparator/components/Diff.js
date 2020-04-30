/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ClayButtonWithIcon} from '@clayui/button';
import ClayCard from '@clayui/card';
import React from 'react';

export default function Diff({diff, onClose, version}) {
	return (
		<ClayCard className="diff-container-column">
			{version && (
				<ClayCard.Row className="card-row-padded diff-version-filter">
					<div className="autofit-row">
						<div className="autofit-col autofit-col-expand">
							<ClayCard.Description displayType="title">
								{version.label}
							</ClayCard.Description>

							<ClayCard.Description displayType="subtitle">
								{version.userName} {version.displayDate}
							</ClayCard.Description>
						</div>

						<div className="autofit-col">
							<ClayButtonWithIcon
								displayType="unstyled"
								onClick={onClose}
								symbol="times"
							/>
						</div>
					</div>
				</ClayCard.Row>
			)}

			<ClayCard.Row className="card-row-padded diff-container">
				<div
					className="taglib-diff-html"
					dangerouslySetInnerHTML={{__html: diff}}
				/>
			</ClayCard.Row>

			<ClayCard.Row className="card-row-padded taglib-diff-html">
				<span className="diff-html-added legend-item">
					{Liferay.Language.get('added')}
				</span>
				<span className="diff-html-removed legend-item">
					{Liferay.Language.get('deleted')}
				</span>
				<span className="diff-html-changed">
					{Liferay.Language.get('format-changes')}
				</span>
			</ClayCard.Row>
		</ClayCard>
	);
}
