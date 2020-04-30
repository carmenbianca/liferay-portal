/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton, {ClayButtonWithIcon} from '@clayui/button';
import React from 'react';

export default function Undo() {
	return (
		<ClayButton.Group className="d-block d-none mr-3">
			<ClayButtonWithIcon
				aria-label={Liferay.Language.get('undo')}
				className="btn-monospaced"
				displayType="secondary"
				small
				symbol="undo"
				title={Liferay.Language.get('undo')}
			/>
			<ClayButtonWithIcon
				aria-label={Liferay.Language.get('redo')}
				className="btn-monospaced"
				displayType="secondary"
				small
				symbol="redo"
				title={Liferay.Language.get('redo')}
			/>
		</ClayButton.Group>
	);
}
