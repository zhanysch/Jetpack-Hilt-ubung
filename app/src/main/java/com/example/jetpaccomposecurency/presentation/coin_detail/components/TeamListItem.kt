package com.example.jetpaccomposecurency.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.jetpaccomposecurency.data.remote.dto.TeamMember


@Composable
fun TeamListItem(
    teamMember: TeamMember,
    modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = teamMember.name,
        style = MaterialTheme.typography.h4 
        )
        Spacer(modifier = androidx.compose.ui.Modifier.height(4.dp))

        Text(text = teamMember.position,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )

    }
}