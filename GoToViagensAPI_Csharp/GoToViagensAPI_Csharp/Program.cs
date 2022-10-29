using Microsoft.EntityFrameworkCore;
using GoToViagensAPI_Csharp.Models;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();


// FAZ A INJE��O DA CONEX�O COM O CONTEXTO
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

app.UseAuthorization();

app.MapControllers();

app.Run();
