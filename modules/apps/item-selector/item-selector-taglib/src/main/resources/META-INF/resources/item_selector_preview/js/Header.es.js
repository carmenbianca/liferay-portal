/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import ClayIcon from '@clayui/icon';
import PropTypes from 'prop-types';
import React from 'react';

const Header = ({
	disabledAddButton = false,
	handleClickAdd,
	handleClickBack,
	handleClickEdit,
	headerTitle,
	infoButtonRef,
	showEditIcon,
	showInfoIcon,
}) => (
	<div className="navbar navigation-bar navigation-bar-light">
		<div className="container-fluid header">
			<nav className="navbar navbar-expand-md navbar-underline navigation-bar navigation-bar-light">
				<div className="container-fluid container-fluid-max-xl">
					<ul className="navbar-nav">
						<li className="nav-item">
							<ClayButton
								borderless
								displayType="secondary"
								monospaced
								onClick={handleClickBack}
							>
								<ClayIcon symbol="angle-left" />
							</ClayButton>
						</li>
						<li className="d-none d-sm-inline-flex nav-item">
							<strong>{headerTitle}</strong>
						</li>
					</ul>
				</div>
			</nav>

			<nav className="navbar navbar-expand-md navbar-underline navigation-bar navigation-bar-light">
				<div className="container-fluid container-fluid-max-xl">
					<ul className="navbar-nav">
						{showEditIcon && (
							<li className="btn-group-item nav-item">
								<ClayButton
									borderless
									displayType="secondary"
									monospaced
									onClick={handleClickEdit}
								>
									<ClayIcon symbol="pencil" />
								</ClayButton>
							</li>
						)}
						{showInfoIcon && (
							<li className="btn-group-item nav-item">
								<ClayButton
									borderless
									displayType="secondary"
									id="infoButtonRef"
									monospaced
									ref={infoButtonRef}
								>
									<ClayIcon symbol="info-panel-open" />
								</ClayButton>
							</li>
						)}
						<li className="nav-item">
							<ClayButton
								disabled={disabledAddButton}
								displayType="primary"
								onClick={handleClickAdd}
							>
								{Liferay.Language.get('add')}
							</ClayButton>
						</li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
);

Header.propTypes = {
	disabledAddButton: PropTypes.bool,
	handleClickAdd: PropTypes.func.isRequired,
	handleClickBack: PropTypes.func.isRequired,
	handleClickEdit: PropTypes.func,
	headerTitle: PropTypes.string.isRequired,
	showEditIcon: PropTypes.bool,
	showInfoIcon: PropTypes.bool,
};

export default Header;
