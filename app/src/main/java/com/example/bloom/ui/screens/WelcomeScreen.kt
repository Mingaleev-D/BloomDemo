package com.example.bloom.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bloom.R
import com.example.bloom.ui.theme.BloomTheme

/**
 * @author : Mingaleev D
 * @data : 02.09.2023
 */

@Composable
fun WelcomeScreen() {
   Surface(
       modifier = Modifier.fillMaxSize(),
       color = MaterialTheme.colors.primary
   ) {
      WelcomeBackground()

      WelcomeScreenContent()
   }
}

@Composable
private fun WelcomeScreenContent() {
   Column(
       modifier = Modifier
           .fillMaxWidth()
           .padding(24.dp),
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
      Spacer(modifier = Modifier.height(72.dp))

      LeafImage()

      Spacer(modifier = Modifier.height(48.dp))

      LogoImage()

      AppSubtitle()

      Spacer(modifier = Modifier.height(48.dp))

      CreateAccountButton()

      Spacer(modifier = Modifier.height(8.dp))

      LoginButton()
   }
}

@Composable
private fun LogoImage() {
   val isLight = MaterialTheme.colors.isLight
   val logoImageRes = if (isLight) {
      R.drawable.ic_light_logo
   } else {
      R.drawable.ic_dark_logo
   }
   Image(
       painter = painterResource(id = logoImageRes),
       contentDescription = null,

       )
}

@Composable
private fun LeafImage() {
   val isLight = MaterialTheme.colors.isLight
   val leafImageRes = if (isLight) {
      R.drawable.ic_light_welcome_illos
   } else {
      R.drawable.ic_dark_welcome_illos
   }
   Image(
       painter = painterResource(id = leafImageRes),
       contentDescription = null,
       contentScale = ContentScale.FillBounds,
       modifier = Modifier.offset(x = 88.dp)
   )
}

@Composable
private fun AppSubtitle() {
   Text(
       text = "Beautiful solution for a home garden",
       style = MaterialTheme.typography.subtitle1,
       modifier = Modifier.paddingFromBaseline(top = 32.dp)
   )
}

@Composable
private fun CreateAccountButton() {
   Button(
       onClick = { /*TODO*/ },
       modifier = Modifier.fillMaxWidth(),
       colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
       shape = MaterialTheme.shapes.medium
   ) {
      Text(text = "Create account")
   }
}

@Composable
private fun LoginButton() {
   TextButton(
       onClick = { /*TODO*/ },
       modifier = Modifier.fillMaxWidth(),
       shape = MaterialTheme.shapes.medium,
       colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colors.onBackground)
   ) {
      Text(text = "Log in")
   }
}

@Composable
private fun WelcomeBackground() {
   val isLight = MaterialTheme.colors.isLight
   val backgroundImageRes = if (isLight) {
      R.drawable.ic_light_welcome_bg
   } else {
      R.drawable.ic_dark_welcome_bg
   }

   Image(
       painter = painterResource(id = backgroundImageRes),
       contentDescription = null,
       modifier = Modifier.fillMaxSize()
   )
}

@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun WelcomeScreenPreview() {
   BloomTheme {
      WelcomeScreen()
   }
}