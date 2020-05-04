<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<h3>Image cards</h3>

<div class="row">
	<div class="col-md-4" id="image-card-block">
		<clay:image-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			href="#1"
			imageAlt="thumbnail"
			imageSrc="https://images.unsplash.com/photo-1506976773555-b3da30a63b57"
			subtitle="Author Action"
			title="Madrid"
		/>
	</div>

	<div class="col-md-4" id="image-card-icon-block">
		<clay:image-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			icon="camera"
			subtitle="Author Action"
			title="<%= _SVG_FILE_TITLE %>"
		/>
	</div>

	<div class="col-md-4" id="image-card-empty-block">
		<clay:image-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			subtitle="Author Action"
			title="<%= _SVG_FILE_TITLE %>"
		/>
	</div>
</div>

<h4>Image Card with Sticker</h4>

<div class="row">
	<div class="col-md-4" id="image-card-block">
		<clay:image-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			href="#1"
			imageAlt="thumbnail"
			imageSrc="https://images.unsplash.com/photo-1499310226026-b9d598980b90"
			stickerLabel="JPG"
			stickerStyle="danger"
			subtitle="Author Action"
			title="California"
		/>
	</div>

	<div class="col-md-4" id="image-card-icon-block">
		<clay:image-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			icon="camera"
			stickerLabel="SVG"
			stickerStyle="warning"
			subtitle="Author Action"
			title="<%= _SVG_FILE_TITLE %>"
		/>
	</div>

	<div class="col-md-4" id="image-card-empty-block">
		<clay:image-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			stickerLabel="PNG"
			stickerStyle="info"
			subtitle="Author Action"
			title="<%= _PNG_FILE_TITLE %>"
		/>
	</div>
</div>

<h4>Image Card with Sticker Shape</h4>

<div class="row">
	<div class="col-md-4" id="image-card-block">
		<clay:image-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			href="#1"
			imageAlt="thumbnail"
			imageSrc="https://images.unsplash.com/photo-1490900245048-1bf948e866c2"
			stickerLabel="JPG"
			stickerShape="circle"
			stickerStyle="danger"
			subtitle="Author Action"
			title="California"
		/>
	</div>

	<div class="col-md-4" id="image-card-icon-block">
		<clay:image-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			icon="camera"
			stickerLabel="SVG"
			stickerShape="circle"
			stickerStyle="warning"
			subtitle="Author Action"
			title="<%= _SVG_FILE_TITLE %>"
		/>
	</div>

	<div class="col-md-4" id="image-card-empty-block">
		<clay:image-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			stickerImageAlt="Alt Text"
			stickerImageSrc="https://images.unsplash.com/photo-1502290822284-9538ef1f1291"
			stickerLabel="PNG"
			stickerShape="circle"
			stickerStyle="info"
			subtitle="Author Action"
			title="<%= _PNG_FILE_TITLE %>"
		/>
	</div>
</div>

<h4>Image Card with Labels</h4>

<div class="row">
	<div class="col-md-4" id="image-card-block">
		<clay:image-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			href="#1"
			imageAlt="thumbnail"
			imageSrc="https://images.unsplash.com/photo-1503703294279-c83bdf7b4bf4"
			labels="<%= cardsDisplayContext.getLabelItems() %>"
			stickerLabel="JPG"
			stickerStyle="danger"
			subtitle="Author Action"
			title="Beetle"
		/>
	</div>

	<div class="col-md-4" id="image-card-icon-block">
		<clay:image-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			icon="camera"
			labels="<%= cardsDisplayContext.getLabelItems() %>"
			labelStylesMap="<%= cardsDisplayContext.getLabelStylesMap() %>"
			stickerLabel="SVG"
			stickerStyle="warning"
			subtitle="Author Action"
			title="<%= _SVG_FILE_TITLE %>"
		/>
	</div>

	<div class="col-md-4" id="image-card-empty-block">
		<clay:image-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			labels="<%= cardsDisplayContext.getLabelItems() %>"
			stickerLabel="PNG"
			stickerStyle="info"
			subtitle="Author Action"
			title="<%= _SVG_FILE_TITLE %>"
		/>
	</div>
</div>

<h4>Selectable Image Card</h4>

<div class="row">
	<div class="col-md-4" id="image-card-block">
		<clay:image-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			href="#1"
			imageAlt="thumbnail"
			imageSrc="https://images.unsplash.com/photo-1506020647804-b04ee956dc04"
			labels="<%= cardsDisplayContext.getLabelItems() %>"
			selectable="<%= true %>"
			selected="<%= true %>"
			stickerLabel="JPG"
			stickerStyle="danger"
			subtitle="Author Action"
			title="Beetle"
		/>
	</div>

	<div class="col-md-4" id="image-card-icon-block">
		<clay:image-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			icon="camera"
			labels="<%= cardsDisplayContext.getLabelItems() %>"
			selectable="<%= true %>"
			selected="<%= false %>"
			stickerLabel="SVG"
			stickerStyle="warning"
			subtitle="Author Action"
			title="<%= _SVG_FILE_TITLE %>"
		/>
	</div>

	<div class="col-md-4" id="image-card-empty-block">
		<clay:image-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			labels="<%= cardsDisplayContext.getLabelItems() %>"
			selectable="<%= true %>"
			selected="<%= true %>"
			stickerLabel="PNG"
			stickerStyle="info"
			subtitle="Author Action"
			title="<%= _SVG_FILE_TITLE %>"
		/>
	</div>
</div>

<h4>File Cards</h4>

<div class="row">
	<div class="col-md-4" id="image-card-block">
		<clay:file-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			labels="<%= cardsDisplayContext.getLabelItems() %>"
			stickerLabel="PDF"
			stickerStyle="danger"
			subtitle="Stevie Ray Vaughn"
			title="<%= _PDF_FILE_TITLE %>"
		/>
	</div>

	<div class="col-md-4" id="image-card-icon-block">
		<clay:file-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			labels="<%= cardsDisplayContext.getLabelItems() %>"
			labelStylesMap="<%= cardsDisplayContext.getLabelStylesMap() %>"
			selectable="<%= true %>"
			selected="<%= true %>"
			stickerLabel="MP3"
			stickerStyle="warning"
			subtitle="Jimi Hendrix"
			title="<%= _MP3_FILE_TITLE %>"
		/>
	</div>

	<div class="col-md-4" id="image-card-empty-block">
		<clay:file-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			icon="list"
			labels="<%= cardsDisplayContext.getLabelItems() %>"
			selectable="<%= true %>"
			selected="<%= true %>"
			stickerLabel="DOC"
			stickerStyle="info"
			subtitle="Paco de Lucia"
			title="<%= _DOC_FILE_TITLE %>"
		/>
	</div>
</div>

<h4>User Cards</h4>

<div class="row">
	<div class="col-md-6" id="image-card-block">
		<clay:user-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			name="User Name"
			subtitle="Latest Action"
			userColorClass="danger"
		/>
	</div>

	<div class="col-md-6" id="image-card-icon-block">
		<clay:user-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			disabled="<%= true %>"
			imageAlt="thumbnail"
			imageSrc="https://images.unsplash.com/photo-1502290822284-9538ef1f1291"
			name="User name"
			selectable="<%= true %>"
			selected="<%= true %>"
			subtitle="Latest Action"
		/>
	</div>
</div>

<h4>Horizontal Cards</h4>

<div class="row">
	<div class="col-md-6" id="image-card-block">
		<clay:horizontal-card
			title="ReallySuperInsanelyJustIncrediblyLongAndTotallyNotPossibleWordButWeAreReallyTryingToCoverAllOurBasesHereJustInCaseSomeoneIsNutsAsPerUsual"
		/>
	</div>

	<div class="col-md-6" id="image-card-icon-block">
		<clay:horizontal-card
			actionDropdownItems="<%= cardsDisplayContext.getActionDropdownItems() %>"
			selectable="<%= true %>"
			selected="<%= true %>"
			title="ReallySuperInsanelyJustIncrediblyLongAndTotallyNotPossibleWordButWeAreReallyTryingToCoverAllOurBasesHereJustInCaseSomeoneIsNutsAsPerUsual"
		/>
	</div>
</div>

<%!
private static final String _DOC_FILE_TITLE = "deliverable.doc";

private static final String _MP3_FILE_TITLE = "deliverable.mp3";

private static final String _PDF_FILE_TITLE = "deliverable.pdf";

private static final String _PNG_FILE_TITLE = "lexicon.icon.camera.png";

private static final String _SVG_FILE_TITLE = "lexicon.icon.camera.svg";
%>