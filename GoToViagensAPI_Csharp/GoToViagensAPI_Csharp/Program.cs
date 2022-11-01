using Microsoft.EntityFrameworkCore;
using GoToViagensAPI_Csharp.Models;

var builder = WebApplication.CreateBuilder(args);


var MyAllowSpecificOrigins = "_myAllowSpecificOrigins";

// DEFINE O ENDENREÇO DE ONDE A APLICAÇÃO REACT VAI RODAR
builder.Services.AddCors(options =>
{
    options.AddPolicy(name: MyAllowSpecificOrigins,
                      policy =>
                      {
                          policy.WithOrigins("http://localhost:19006")
                                               .AllowAnyHeader()
                                               .AllowAnyMethod();
                      });
});


// services.AddResponseCaching();



builder.Services.AddControllers();





// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();


// FAZ A INJEÇÃO DA CONEXÃO COM O CONTEXTO
builder.Services.AddDbContext<DestinoDbContext>(options =>
{
    options.UseSqlServer(builder.Configuration.GetConnectionString("Conexao"));
});



var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}


app.UseHttpsRedirection();

// new
app.UseStaticFiles();
app.UseRouting();


// CHAMADA DO CORS
app.UseCors(MyAllowSpecificOrigins);


app.UseAuthorization();
app.MapControllers();

app.Run();
