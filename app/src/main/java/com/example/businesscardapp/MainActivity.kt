package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun DesignationInfo(image: Painter, name: String, designation: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(135.dp)
                .width(135.dp)
                .background(Color(0xFF073042))
        )
        Text(
            text = name,
            fontSize = 38.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(top = 15.dp)
        )
        Text(
            text = designation,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF066537),
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Composable
fun ContactInfo(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        ContactInfoRow(
            icon = Icons.Rounded.Call,
            contactInfo = stringResource(R.string.phone_number)
        )
        ContactInfoRow(
            icon = Icons.Rounded.Share,
            contactInfo = stringResource(R.string.social_media_name)
        )
        ContactInfoRow(
            icon = Icons.Rounded.Email,
            contactInfo = stringResource(R.string.email_text)
        )
    }
}

@Composable
fun ContactInfoRow(icon: ImageVector, contactInfo: String, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(10.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF046a3a)
        )
        Spacer(modifier = Modifier.width(25.dp))
        Text(
            text = contactInfo
        )
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFd2e7d4))
    ) {
        Spacer(modifier = Modifier.height(200.dp))
        DesignationInfo(
            image = painterResource(id = R.drawable.android_logo),
            name = stringResource(R.string.developer_name_text),
            designation = stringResource(R.string.developer_designation)
        )
        Spacer(modifier = Modifier.height(150.dp))
        ContactInfo()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardAppTheme {
        BusinessCard()
    }
}